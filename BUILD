package(default_visibility = ["//visibility:public"])

load("@bazel_tools//tools/build_defs/pkg:pkg.bzl", "pkg_tar")
load("@com_github_grpc_java//:java_grpc_library.bzl", "java_grpc_library")

RELEASE_VERSION = "0.0.1"
# build package of runtime.
pkg_tar(
    name = "jar-" + RELEASE_VERSION,
    extension = "tar.gz",
    srcs = [
        ":jar",
        "//:src/main/resources/config.yaml",
    ],
    mode = "0755",
)

java_binary(
    name = "jar",
    main_class = "com.toms.less.App",
    runtime_deps = [
        ":main",
    ],
)

java_library(
    name = "main",
    srcs = glob(
        ["src/main/java/**/*.java"],
    ),
    resources = glob(
        ["src/main/resources/**"],
    ),
    runtime_deps = [
        "@com_github_grpc_java//netty",
    ],
    deps = [
        ":runtime_grpc_lib",
        ":runtime_proto_lib",
        "@maven//:org_slf4j_log4j_over_slf4j",
        "@maven//:org_slf4j_jul_to_slf4j",
        "@maven//:ch_qos_logback_logback_core",
        "@maven//:ch_qos_logback_logback_classic",
        "@maven//:log4j_log4j",
        "@maven//:commons_logging_commons_logging",
        "@maven//:org_apache_commons_commons_lang3",
        "@maven//:com_google_inject_guice",
        "@maven//:com_esotericsoftware_yamlbeans_yamlbeans",
        "@maven//:com_google_code_gson_gson",
    ],
)

java_grpc_library(
    name = "runtime_grpc_lib",
    srcs = [":runtime_proto_lib"],
    deps = [":runtime_proto"],
)

java_proto_library(
    name = "runtime_proto_lib",
    deps = [":runtime_proto"],
)

proto_library(
    name = "runtime_proto",
    srcs = ["src/main/java/com/toms/less/protos/runtime.proto"],
    deps = ["@com_google_protobuf//:any_proto"],
)
