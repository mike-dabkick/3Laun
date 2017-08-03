package com.dabkick.dabtv.a3laun;

import android.media.tv.TvInputService;

/**
 * Created by mike on 8/2/2017.
 */

public class HDMIInputService extends android.media.tv.TVInputService {
    public class HDMIInputService extends TvInputService
    {

        private int HDMI_HW_ID = 1;
        private TvInputInfo mTvInputInfo;

        @Override
        public Session onCreateSession(String inputId)
        {
            return new HDMISession(this, inputId);
        }

        @Override
        public TvInputInfo onHardwareAdded(TvInputHardwareInfo hardwareInfo)
        {
            Context context = getApplicationContext();
            ResolveInfo ri = context.getPackageManager().resolveService(new Intent("android.media.tv.TvInputService"),            PackageManager.GET_INTENT_FILTERS | PackageManager.GET_META_DATA);
            mTvInputInfo = TvInputInfo.createTvInputInfo(context, ri, hardwareInfo, null, TvContract.buildChannelUriForPassthroughInput(Id));
            return mTvInputInfo;
        }
        @Override
        public String onHardwareRemoved(TvInputHardwareInfo hardwareInfo)
        {
            return null;
        }

        private class  HDMISession extends Session
        {

            private final Context mContext;
            private final String mInputId;
            private Surface mSurface;
            private float mVolume;
            private boolean mCaptionEnabled;
            private TvInputManager mTvInputManager;
            private TvInputManager.Hardware mHardware;
            private TvStreamConfig[] mTvStreamConfig;

            private final TvInputManager.HardwareCallback mHardwareCallback = new TvInputManager.HardwareCallback() {

                @Override
                public void onReleased() { }

                @Override
                public void onStreamConfigChanged(TvStreamConfig[] configs)
                {
                    mTvStreamConfig = configs;
                }

            };

            HDMISession (Context context, String inputId)
            {
                super(context);
                mContext = context;
                mInputId = inputId;
                mTvInputManager = (TvInputManager) context.getSystemService(Context.TV_INPUT_SERVICE);
                mHardware = mTvInputManager.acquireTvInputHardware(HDMI_HW_ID, mHardwareCallback, mTvInputInfo);
            }
            @Override
            public void onRelease() {
                mTvInputManager.releaseTvInputHardware(HDMI_HW_ID, mHardware);
            }
            @Override
            public boolean onSetSurface(Surface surface)
            {
                mSurface = surface;
                mHardware.setSurface(mSurface, mTvStreamConfig[0]);
                return true;
            }
            @Override
            public void onSetStreamVolume(float volume)
            {
                mVolume = volume;
            }
            @Override
            public boolean onTune(Uri channeluri)
            {
                notifyVideoUnavailable(TvInputManager.VIDEO_UNAVAILABLE_REASON_TUNING);
                notifyVideoAvailable();
                return true;
            }
            @Override
            public void onSetCaptionEnabled(boolean enabled)
            {
                mCaptionEnabled = enabled;
            }
            @Override
            public boolean onKeyUp(int keyCode, KeyEvent event) {
                return false; //if not handling, otherwise return true
            }

        }

    }
}
