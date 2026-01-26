SUMMARY = "c1 Image"
LICENSE = "MIT"
PV = "1"
IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp ;"
IMAGE_LINGUAS = "en-us"

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@oe.utils.conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

IMAGE_FEATURES:append = " \
    debug-tweaks \
    ssh-server-openssh \
"

TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server openssh-misc"

IMAGE_INSTALL:append = " \
    packagegroup-base \
    packagegroup-hostmobility-can \
    packagegroup-hostmobility-python \
    packagegroup-hostmobility-base \
    packagegroup-hostmobility-net-minimal \
    packagegroup-c1-base \
    udev-extra-rules \
    ${ROOTFS_PKGMANAGE_PKGS} \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    packagegroup-core-full-cmdline-utils \
    ${TASK_BASIC_SSHDAEMON} \
"

# Remove problematic packagegroups that are added by packagegroup-base, core-image, or machine configs
# This must come after IMAGE_INSTALL:append to ensure it removes packages added by those appends
IMAGE_INSTALL:remove = " \
    packagegroup-tools-bluetooth \
    packagegroup-base-extended \
    packagegroup-base-3g \
    packagegroup-base-nfs \
"

# Also remove from machine-specific install list (runs after machine-specific appends)
IMAGE_INSTALL:remove:imx8mp-var-dart = " \
    packagegroup-tools-bluetooth \
    packagegroup-base-extended \
    packagegroup-base-3g \
    packagegroup-base-nfs \
"

# Use PACKAGE_EXCLUDE to remove packages even if they're dependencies
PACKAGE_EXCLUDE = " \
    ofono \
    bluez5 \
    bluez5-obex \
    rpcbind \
    gpsd-udev \
    gpsd-conf \
"

# Allow opkg to ignore dependency conflicts for excluded packages
# This allows packagegroup-base to install even though we exclude its sub-packagegroups
OPKG_ARGS += "--force-depends"

IMAGE_INSTALL:append:imx8mp-var-dart = " \
    libiio \
    ethtool \
"

BBMASK = "meta-variscite-imx/recipes-core/systemd/systemd_%.bbappend"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

export IMAGE_BASENAME = "c1-image"

inherit core-image

TOOLCHAIN_TARGET_TASK:append = " kernel-devsrc"
