SUMMARY = "mobility-c1 based image package groups"
DESCRIPTION = "Package groups for mobility-c1 based applications and tools"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = " \
    ${PN} \
    ${PN}-can \
    ${PN}-connectivity \
    ${PN}-tools \
"

# Everything a production unit needs
RDEPENDS:${PN} = " \
    ${PN}-can \
    ${PN}-connectivity \
    ${PN}-tools \
"
# CAN/CAN FD bus support
RDEPENDS:${PN}-can = " \
    can-utils \
    iproute2 \
"

# ethtool is needed to set up the T1 ethernet configuration
RDEPENDS:${PN}-connectivity = " \
    ppp \
    iptables \
    avahi-utils \
    usb-rndis-udev \
    ethtool \
    strace \
    tcpdump \
"

RDEPENDS:${PN}-tools = " \
    libgpiod-tools \
    i2c-tools \
    lmsensors-sensors \
    opkg \
    distro-feed-configs \
    tzdata \
    fs-init \
    minicom \
    lrzsz \
    htop \
    libiio-tests \
"
