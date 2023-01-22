const StyleLintPlugin = require("stylelint-webpack-plugin");

module.exports = function override(config, env) {
  if (env === "development") {
    config.plugins.push(
      new StyleLintPlugin({
        context: "src",
        lintDirtyModulesOnly: true,
      }),
    );
  }

  return config;
};