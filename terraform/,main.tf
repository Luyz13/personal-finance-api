terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 2.15.0"
    }
  }
}

provider "docker" {
  host = "npipe:////.//pipe//docker_engine"
}

resource "docker_image" "mysql" {
  name         = "mysql:8.0"
  keep_locally = false
}

resource "docker_network" "private_network" {
  name   = "finance_network"
  driver = "bridge"
}

resource "docker_container" "mysql" {
  image = docker_image.mysql.name
  name  = "finance_db"

  env = [
    "MYSQL_ROOT_PASSWORD=secret",
    "MYSQL_DATABASE=financeDB",
    "MYSQL_USER=finance_user",
    "MYSQL_PASSWORD=finace_pass"
  ]

  ports {
    internal = 3306
    external = 3306
  }

  volumes {
    host_path      = "C:\\\\mysql_data\\\\financeDB"
    container_path = "/var/lib/mysql"
  }

  networks_advanced {
    name = docker_network.private_network.name
  }

  restart = "unless-stopped"
}