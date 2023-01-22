const {
  propertyOrdering,
  selectorOrdering,
} = require("stylelint-semantic-groups");

module.exports = {
  "extends": [
    "stylelint-config-standard",
    "stylelint-config-prettier",
    "stylelint-config-idiomatic-order",
    "stylelint-config-css-modules",
  ],
  "plugins": [
    "stylelint-scss",
    "stylelint-order",
    "stylelint-no-unsupported-browser-features",
  ],
  "rules": {
    "declaration-empty-line-before": [
      "always",
      {
        "except": [
          "first-nested",
        ],
        "ignore": [
          "after-comment",
          "after-declaration",
          "inside-single-line-block",
        ],
      },
    ],
    "selector-class-pattern": null,
    "custom-property-pattern": null,
    "keyframes-name-pattern": null,
    "property-no-vendor-prefix": null,
    "color-function-notation": "legacy",
    "alpha-value-notation": "number",
    "no-descending-specificity": null,
    "value-no-vendor-prefix": null,
    "declaration-block-no-redundant-longhand-properties": [ true, { "ignoreShorthands": [ "/flex/" ] } ],
    "order/order": selectorOrdering,
    "order/properties-order": propertyOrdering,
    "plugin/no-unsupported-browser-features": [ true, {
      "ignorePartialSupport": true,
      "ignore": [ "multicolumn" ],
      "severity": "warning",
    } ],
  },
};

