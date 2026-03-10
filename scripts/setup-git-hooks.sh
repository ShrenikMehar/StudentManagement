#!/bin/sh

echo "Configuring Git hooks..."

# Tell git to use repository hooks
git config core.hooksPath .githooks

# Ensure hooks are executable
chmod +x .githooks/pre-commit
chmod +x .githooks/pre-push

echo "Git hooks configured."
