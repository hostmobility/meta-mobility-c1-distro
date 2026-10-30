SUMMARY = "mobility-c1 test package group"
DESCRIPTION = "Test and verification tools, only for mobility-c1-image-test"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# iperf3 and stress-ng come from meta-oe
# procps replaces the busybox pgrep/pkill
RDEPENDS:${PN} = " \
    iperf3 \
    stress-ng \
    procps \
"
