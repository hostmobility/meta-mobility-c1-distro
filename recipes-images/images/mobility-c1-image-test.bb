require mobility-c1-image.bb

SUMMARY = "mobility-c1 test Image"

IMAGE_INSTALL:append = " \
    packagegroup-mobility-c1-test \
"
