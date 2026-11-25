SUMMARY = "c1 based image package group"
DESCRIPTION = "Package group base applications"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = " \
    iptables \
    strace \
    tcpdump \
    avahi-utils \
"

