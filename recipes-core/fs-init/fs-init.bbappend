# Use the version of resizefs.sh in this layer which mounts /mnt/config and does a run-parts on /mnt/config/hooks
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

do_install:append() {
    install -d ${D}/mnt/config
}

FILES:${PN} += "/mnt /mnt/config"
