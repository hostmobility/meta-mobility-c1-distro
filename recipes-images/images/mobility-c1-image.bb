SUMMARY = "mobility-c1 Image"
LICENSE = "MIT"
IMAGE_LINGUAS = "en-us"

IMAGE_FEATURES:append = " \
    debug-tweaks \
    ssh-server-openssh \
"

IMAGE_INSTALL:append = " \
    packagegroup-base \
    packagegroup-mobility-c1-base \
    packagegroup-core-full-cmdline-utils \
    udev-extra-rules \
    openssh-sftp \
    openssh-misc \
"

# packagegroup-tools-bluetooth comes from variscite.inc, packagegroup-base-extended
# from core-image. packagegroup-base-3g/-nfs can not be removed here, they are
# RDEPENDS of packagegroup-base and follow DISTRO_FEATURES.
IMAGE_INSTALL:remove = " \
    packagegroup-tools-bluetooth \
    packagegroup-base-extended \
"

inherit core-image

TOOLCHAIN_TARGET_TASK:append = " kernel-devsrc"
