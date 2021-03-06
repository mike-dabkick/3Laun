package com.dabkick.dabtv.a3laun;

import android.app.IntentService;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
/**
 * Created by mike on 8/1/2017.
 */

public class dispdev     {
        public static final String[] hdmifiles  = {
                "/sys/bus/i2c/drivers/tc358749_hdmiin/bind",
                "/sys/bus/i2c/drivers/tc358749_hdmiin/uevent",
                "/sys/bus/i2c/drivers/tc358749_hdmiin/unbind",
                "/sys/bus/platform/drivers/rk-hdmi/bind",
                "/sys/bus/platform/drivers/rk-hdmi/uevent",
                "/sys/bus/platform/drivers/rk-hdmi/unbind",
                "/sys/bus/platform/drivers/rgb2hdmi/bind",
                "/sys/bus/platform/drivers/rgb2hdmi/uevent",
                "/sys/bus/platform/drivers/rgb2hdmi/unbind",
                "/sys/bus/platform/drivers/hdmi-spdif/bind",
                "/sys/bus/platform/drivers/hdmi-spdif/uevent",
                "/sys/bus/platform/drivers/hdmi-spdif/unbind",
                "/sys/bus/platform/drivers/rockchip-hdmi-i2s/bind",
                "/sys/bus/platform/drivers/rockchip-hdmi-i2s/uevent",
                "/sys/bus/platform/drivers/rockchip-hdmi-i2s/unbind",
                "/sys/bus/platform/drivers/hdmi-i2s/bind",
                "/sys/bus/platform/drivers/hdmi-i2s/uevent",
                "/sys/bus/platform/drivers/hdmi-i2s/unbind",
                "/sys/bus/platform/drivers/rockchip-hdmiv2/bind",
                "/sys/bus/platform/drivers/rockchip-hdmiv2/uevent",
                "/sys/bus/platform/drivers/rockchip-hdmiv2/unbind",
                "/sys/devices/ff980000.hdmi/power/control",
                "/sys/devices/ff980000.hdmi/power/runtime_active_time",
                "/sys/devices/ff980000.hdmi/power/autosuspend_delay_ms",
                "/sys/devices/ff980000.hdmi/power/runtime_status",
                "/sys/devices/ff980000.hdmi/power/runtime_suspended_time",
                "/sys/devices/ff980000.hdmi/modalias",
                "/sys/devices/ff980000.hdmi/uevent",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/edidread",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/name",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/mode",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/type",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/connect",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/color",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/debug",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/modes",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/power/control",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/power/runtime_active_time",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/power/autosuspend_delay_ms",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/power/runtime_status",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/power/runtime_suspended_time",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/scale",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/audioinfo",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/monspecs",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/enable",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/uevent",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/property",
                "/sys/devices/rgb2hdmi.29/display/HDMI1/3dmode",
                "/sys/devices/rgb2hdmi.29/power/control",
                "/sys/devices/rgb2hdmi.29/power/runtime_active_time",
                "/sys/devices/rgb2hdmi.29/power/autosuspend_delay_ms",
                "/sys/devices/rgb2hdmi.29/power/runtime_status",
                "/sys/devices/rgb2hdmi.29/power/runtime_suspended_time",
                "/sys/devices/rgb2hdmi.29/modalias",
                "/sys/devices/rgb2hdmi.29/uevent",
                "/sys/devices/codec-hdmi-i2s.23/power/control",
                "/sys/devices/codec-hdmi-i2s.23/power/runtime_active_time",
                "/sys/devices/codec-hdmi-i2s.23/power/autosuspend_delay_ms",
                "/sys/devices/codec-hdmi-i2s.23/power/runtime_status",
                "/sys/devices/codec-hdmi-i2s.23/power/runtime_suspended_time",
                "/sys/devices/codec-hdmi-i2s.23/modalias",
                "/sys/devices/codec-hdmi-i2s.23/uevent",
                "/sys/devices/virtual/display/HDMI/edidread",
                "/sys/devices/virtual/display/HDMI/name",
                "/sys/devices/virtual/display/HDMI/mode",
                "/sys/devices/virtual/display/HDMI/type",
                "/sys/devices/virtual/display/HDMI/connect",
                "/sys/devices/virtual/display/HDMI/color",
                "/sys/devices/virtual/display/HDMI/debug",
                "/sys/devices/virtual/display/HDMI/modes",
                "/sys/devices/virtual/display/HDMI/power/control",
                "/sys/devices/virtual/display/HDMI/power/runtime_active_time",
                "/sys/devices/virtual/display/HDMI/power/autosuspend_delay_ms",
                "/sys/devices/virtual/display/HDMI/power/runtime_status",
                "/sys/devices/virtual/display/HDMI/power/runtime_suspended_time",
                "/sys/devices/virtual/display/HDMI/scale",
                "/sys/devices/virtual/display/HDMI/audioinfo",
                "/sys/devices/virtual/display/HDMI/monspecs",
                "/sys/devices/virtual/display/HDMI/enable",
                "/sys/devices/virtual/display/HDMI/uevent",
                "/sys/devices/virtual/display/HDMI/property",
                "/sys/devices/virtual/display/HDMI/3dmode",
                "/sys/devices/virtual/switch/hdmi/name",
                "/sys/devices/virtual/switch/hdmi/power/control",
                "/sys/devices/virtual/switch/hdmi/power/runtime_active_time",
                "/sys/devices/virtual/switch/hdmi/power/autosuspend_delay_ms",
                "/sys/devices/virtual/switch/hdmi/power/runtime_status",
                "/sys/devices/virtual/switch/hdmi/power/runtime_suspended_time",
                "/sys/devices/virtual/switch/hdmi/state",
                "/sys/devices/virtual/switch/hdmi/uevent",
                "/sys/devices/codec-hdmi-spdif.24/power/control",
                "/sys/devices/codec-hdmi-spdif.24/power/runtime_active_time",
                "/sys/devices/codec-hdmi-spdif.24/power/autosuspend_delay_ms",
                "/sys/devices/codec-hdmi-spdif.24/power/runtime_status",
                "/sys/devices/codec-hdmi-spdif.24/power/runtime_suspended_time",
                "/sys/devices/codec-hdmi-spdif.24/modalias",
                "/sys/devices/codec-hdmi-spdif.24/uevent",
                "/sys/class/hdmiin_reg/hdmiin",
                "/sys/class/hdmiin_reg/hdmiin_audio",
                "/sys/firmware/devicetree/base/rgb2hdmi/name",
                "/sys/firmware/devicetree/base/rgb2hdmi/power-gpio",
                "/sys/firmware/devicetree/base/rgb2hdmi/compatible",
                "/sys/firmware/devicetree/base/rgb2hdmi/hpd-gpio",
                "/sys/firmware/devicetree/base/rgb2hdmi/rockchip,prop",
                "/sys/firmware/devicetree/base/rgb2hdmi/lcdc-gpio",
                "/sys/firmware/devicetree/base/rgb2hdmi/status",
                "/sys/firmware/devicetree/base/rgb2hdmi/rockchip,source",
                "/sys/firmware/devicetree/base/hdmi_hdcp2@ff974000/reg",
                "/sys/firmware/devicetree/base/hdmi_hdcp2@ff974000/name",
                "/sys/firmware/devicetree/base/hdmi_hdcp2@ff974000/compatible",
                "/sys/firmware/devicetree/base/hdmi_hdcp2@ff974000/clock-names",
                "/sys/firmware/devicetree/base/hdmi_hdcp2@ff974000/clocks",
                "/sys/firmware/devicetree/base/hdmi_hdcp2@ff974000/status",
                "/sys/firmware/devicetree/base/hdmi@ff980000/reg",
                "/sys/firmware/devicetree/base/hdmi@ff980000/name",
                "/sys/firmware/devicetree/base/hdmi@ff980000/interrupts",
                "/sys/firmware/devicetree/base/hdmi@ff980000/pinctrl-0",
                "/sys/firmware/devicetree/base/hdmi@ff980000/pinctrl-1",
                "/sys/firmware/devicetree/base/hdmi@ff980000/rockchip,cec_enable",
                "/sys/firmware/devicetree/base/hdmi@ff980000/rockchip,hdmi_video_source",
                "/sys/firmware/devicetree/base/hdmi@ff980000/compatible",
                "/sys/firmware/devicetree/base/hdmi@ff980000/clock-names",
                "/sys/firmware/devicetree/base/hdmi@ff980000/rockchip,hdmi_audio_source",
                "/sys/firmware/devicetree/base/hdmi@ff980000/clocks",
                "/sys/firmware/devicetree/base/hdmi@ff980000/status",
                "/sys/firmware/devicetree/base/hdmi@ff980000/rockchip,hdcp_enable",
                "/sys/firmware/devicetree/base/hdmi@ff980000/pinctrl-names",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk0_mux/reg",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk0_mux/name",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk0_mux/#clock-cells",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk0_mux/compatible",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk0_mux/clocks",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk0_mux/clock-output-names",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk0_mux/rockchip,bits",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk0_mux/phandle",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk0_mux/#clock-init-cells",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk0_mux/linux,phandle",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk1_mux/reg",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk1_mux/name",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk1_mux/#clock-cells",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk1_mux/compatible",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk1_mux/clocks",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk1_mux/clock-output-names",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk1_mux/rockchip,bits",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk1_mux/phandle",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk1_mux/#clock-init-cells",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk1_mux/linux,phandle",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk_mux/reg",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk_mux/name",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk_mux/#clock-cells",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk_mux/compatible",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk_mux/clocks",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk_mux/clock-output-names",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk_mux/rockchip,bits",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk_mux/phandle",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk_mux/#clock-init-cells",
                "/sys/firmware/devicetree/base/clocks/special_regs/hdmi_dclk_mux/linux,phandle",
                "/sys/firmware/devicetree/base/clocks/pd_cons/pd_hdmi/name",
                "/sys/firmware/devicetree/base/clocks/pd_cons/pd_hdmi/#clock-cells",
                "/sys/firmware/devicetree/base/clocks/pd_cons/pd_hdmi/compatible",
                "/sys/firmware/devicetree/base/clocks/pd_cons/pd_hdmi/rockchip,pd-id",
                "/sys/firmware/devicetree/base/clocks/pd_cons/pd_hdmi/clocks",
                "/sys/firmware/devicetree/base/clocks/pd_cons/pd_hdmi/clock-output-names",
                "/sys/firmware/devicetree/base/pinctrl@ff770000/gpio7_cec/hdmi-cec-gpio/name",
                "/sys/firmware/devicetree/base/pinctrl@ff770000/gpio7_cec/hdmi-cec-gpio/rockchip,drive",
                "/sys/firmware/devicetree/base/pinctrl@ff770000/gpio7_cec/hdmi-cec-gpio/rockchip,pins",
                "/sys/firmware/devicetree/base/pinctrl@ff770000/gpio7_cec/hdmi-cec-gpio/rockchip,pull",
                "/sys/firmware/devicetree/base/pinctrl@ff770000/gpio7_cec/hdmi-cec/name",
                "/sys/firmware/devicetree/base/pinctrl@ff770000/gpio7_cec/hdmi-cec/rockchip,drive",
                "/sys/firmware/devicetree/base/pinctrl@ff770000/gpio7_cec/hdmi-cec/rockchip,pins",
                "/sys/firmware/devicetree/base/pinctrl@ff770000/gpio7_cec/hdmi-cec/rockchip,pull",
                "/sys/firmware/devicetree/base/pinctrl@ff770000/gpio7_cec/hdmi-cec/phandle",
                "/sys/firmware/devicetree/base/pinctrl@ff770000/gpio7_cec/hdmi-cec/linux,phandle",
                "/sys/firmware/devicetree/base/codec-hdmi-i2s/name",
                "/sys/firmware/devicetree/base/codec-hdmi-i2s/compatible",
                "/sys/firmware/devicetree/base/codec-hdmi-i2s/phandle",
                "/sys/firmware/devicetree/base/codec-hdmi-i2s/linux,phandle",
                "/sys/firmware/devicetree/base/rockchip-hdmi-i2s/dais/dai0/name",
                "/sys/firmware/devicetree/base/rockchip-hdmi-i2s/dais/dai0/format",
                "/sys/firmware/devicetree/base/rockchip-hdmi-i2s/dais/dai0/audio-controller",
                "/sys/firmware/devicetree/base/rockchip-hdmi-i2s/dais/dai0/audio-codec",
                "/sys/firmware/devicetree/base/rockchip-hdmi-i2s/dais/name",
                "/sys/firmware/devicetree/base/rockchip-hdmi-i2s/name",
                "/sys/firmware/devicetree/base/rockchip-hdmi-i2s/compatible",
                "/sys/firmware/devicetree/base/rockchip-hdmi-i2s/status",
                "/sys/firmware/devicetree/base/codec-hdmi-spdif/name",
                "/sys/firmware/devicetree/base/codec-hdmi-spdif/compatible",
                "/sys/firmware/devicetree/base/codec-hdmi-spdif/phandle",
                "/sys/firmware/devicetree/base/codec-hdmi-spdif/linux,phandle",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc1/hdmi_dclk1/clk_notifier_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc1/hdmi_dclk1/clk_enable_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc1/hdmi_dclk1/clk_prepare_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc1/hdmi_dclk1/clk_flags",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc1/hdmi_dclk1/clk_rate",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc0/hdmi_dclk0/hdmi_dclk/clk_notifier_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc0/hdmi_dclk0/hdmi_dclk/clk_enable_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc0/hdmi_dclk0/hdmi_dclk/clk_prepare_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc0/hdmi_dclk0/hdmi_dclk/clk_flags",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc0/hdmi_dclk0/hdmi_dclk/clk_rate",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc0/hdmi_dclk0/clk_notifier_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc0/hdmi_dclk0/clk_enable_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc0/hdmi_dclk0/clk_prepare_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc0/hdmi_dclk0/clk_flags",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/dclk_lcdc0/hdmi_dclk0/clk_rate",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/aclk_vio0/g_aclk_vio0_niu/hclk_vio/g_p_hdmi_ctrl/clk_notifier_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/aclk_vio0/g_aclk_vio0_niu/hclk_vio/g_p_hdmi_ctrl/clk_enable_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/aclk_vio0/g_aclk_vio0_niu/hclk_vio/g_p_hdmi_ctrl/clk_prepare_count",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/aclk_vio0/g_aclk_vio0_niu/hclk_vio/g_p_hdmi_ctrl/clk_flags",
                "/sys/kernel/debug/clk/xin24m/clk_gpll/aclk_vio0/g_aclk_vio0_niu/hclk_vio/g_p_hdmi_ctrl/clk_rate",
                "/sys/kernel/debug/clk/xin24m/g_hdmi_hdcp_clk/clk_notifier_count",
                "/sys/kernel/debug/clk/xin24m/g_hdmi_hdcp_clk/clk_enable_count",
                "/sys/kernel/debug/clk/xin24m/g_hdmi_hdcp_clk/clk_prepare_count",
                "/sys/kernel/debug/clk/xin24m/g_hdmi_hdcp_clk/clk_flags",
                "/sys/kernel/debug/clk/xin24m/g_hdmi_hdcp_clk/clk_rate",
                "/sys/kernel/debug/clk/xin32k/g_hdmi_cec_clk/clk_notifier_count",
                "/sys/kernel/debug/clk/xin32k/g_hdmi_cec_clk/clk_enable_count",
                "/sys/kernel/debug/clk/xin32k/g_hdmi_cec_clk/clk_prepare_count",
                "/sys/kernel/debug/clk/xin32k/g_hdmi_cec_clk/clk_flags",
                "/sys/kernel/debug/clk/xin32k/g_hdmi_cec_clk/clk_rate",
                "/sys/kernel/debug/clk/orphans/pd_vio/pd_hdmi/clk_notifier_count",
                "/sys/kernel/debug/clk/orphans/pd_vio/pd_hdmi/clk_enable_count",
                "/sys/kernel/debug/clk/orphans/pd_vio/pd_hdmi/clk_prepare_count",
                "/sys/kernel/debug/clk/orphans/pd_vio/pd_hdmi/clk_flags",
                "/sys/kernel/debug/clk/orphans/pd_vio/pd_hdmi/clk_rate",
                "/sys/kernel/debug/asoc/RK-SPDIF-CARD/codec-hdmi-spdif.24/dapm/Playback",
                "/sys/kernel/debug/asoc/RK-SPDIF-CARD/codec-hdmi-spdif.24/dapm/bias_level",
                "/sys/kernel/debug/asoc/RK-SPDIF-CARD/codec-hdmi-spdif.24/codec_reg",
                "/sys/kernel/debug/asoc/RK-SPDIF-CARD/codec-hdmi-spdif.24/cache_only",
                "/sys/kernel/debug/asoc/RK-SPDIF-CARD/codec-hdmi-spdif.24/cache_sync",
                "/sys/kernel/debug/rockchip_hdmiv2/regs_phy",
                "/sys/kernel/debug/rockchip_hdmiv2/regs_ctrl",
        };

        private static final String TAG = "hdmitest";
        public static void testlist() {
            try {
                for (String el : hdmifiles) {
                    Log.d(TAG, "testing file: " + el);
                    InputStreamReader isr = new InputStreamReader(new FileInputStream(el), StandardCharsets.UTF_8);
                    int rets[] = {0, 0, 0, 0};
                    for (int i = 0; i < 4; ++i) {
                        rets[i] = isr.read();
                    }
                    System.err.println(String.format("%s %02x %02x %02x %02x", el, rets[0], rets[1], rets[2], rets[3]));
                    Log.d(TAG, String.format("%s %02x %02x %02x %02x\n", el, rets[0], rets[1], rets[2], rets[3]));
                }
            } catch(Exception e) {


            }

        }


 //       public class TmrTest extends IntentService {
  //       }
}
