module.exports = {
    parser: '@typescript-eslint/parser',
    parserOptions: {
        ecmaVersion: 2020,
        sourceType: 'module',
        ecmaFeatures: {
            jsx: true,
        },
    },
    settings: {
        react: {
            version: 'detect',
        },
        'import/resolver': {
            node: {
                extensions: [ '.js', '.jsx', '.ts', '.tsx' ],
                moduleDirectory: [ 'node_modules', 'src' ],
            },
        },
    },
    plugins: [ '@typescript-eslint', 'react', 'react-hooks', 'import' ],
    extends: [
        'eslint:recommended',
        'plugin:@typescript-eslint/recommended',
        'plugin:react/recommended',
        'plugin:react-hooks/recommended',
        'plugin:import/errors',
        'plugin:import/warnings',
        'plugin:import/typescript',
        'prettier',
    ],
    rules: {
        'react/display-name': 'off',
        'react/prop-types': 'off',
        'no-undef': 'off',
        '@typescript-eslint/explicit-module-boundary-types': 'off',
        '@typescript-eslint/no-explicit-any': 'warn',
        'react/react-in-jsx-scope': 'off',
        "import/order": [
            "error",
            {
                "groups": [ [ "builtin", "external", "internal" ] ],
                "pathGroups": [
                    {
                        "pattern": "{react,react-dom,react-router-dom}",
                        "group": "external",
                        "position": "before"
                    }
                ],
                "pathGroupsExcludedImportTypes": [ "react" ],
                "newlines-between": "always",
                "alphabetize": {
                    "order": "asc",
                    "caseInsensitive": true
                }
            }
        ],
        'react-hooks/rules-of-hooks': 'error',
        'react-hooks/exhaustive-deps': 'warn',
    },
    ignorePatterns: [ 'node_modules/', 'build/', 'dist/' ],
};
