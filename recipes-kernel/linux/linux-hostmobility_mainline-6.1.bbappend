FILESEXTRAPATHS:prepend:="${THISDIR}/${PN}:"
SRC_URI:append=" file://extra.cfg"

do_configure:append() {
    cat ${WORKDIR}/*.cfg >> ${B}/.config
}