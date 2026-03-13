Vagrant.configure("2") do |config|
  config.vm.box = "utm/bookworm"

  config.vm.provider :utm do |utm|
    utm.cpus = 2
    utm.memory = "2048"
  end

  config.vm.network "forwarded_port", guest: 8080, host: 8080

  config.vm.provision "shell", path: "infra/provision.sh"
end
