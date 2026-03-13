#!/usr/bin/env bash
set -e

echo "Updating packages..."
sudo apt-get update -y

echo "Installing Docker..."
sudo apt-get install -y docker.io docker-compose

sudo usermod -aG docker vagrant
