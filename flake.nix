{
  description = "Dev shell avec Node.js et npm-check-updates";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = nixpkgs.legacyPackages.${system};
        name = "rest_api";
        version = "0.0.1";
      in {
        # packages.default = pkgs.stdenv.mkDerivation {
        #   pname = name;
        #   version = version;

        #   src = ./.;

        #   nativeBuildInputs = [
        #     pkgs.maven
        #   ];
        #   buildInputs = [ pkgs.jdk ];

        #   buildPhase = ''
        #     mvn package
        #   '';

        #   installPhase = ''
        #     mkdir -p $out/bin
        #     cp target/* $out/
        #     echo "#!/bin/sh" > $out/bin/${name}
        #     echo "exec ${pkgs.jre}/bin/java -jar $out/${name}-${version}.jar" >> $out/bin/${name}-${version}
        #     chmod +x $out/bin/${name}-${version}
        #   '';
        # };
        devShells = {
          default = pkgs.mkShell {
            nativeBuildInputs = with pkgs; [
              jdk
              maven
              jdt-language-server
              nodejs
              nodePackages.npm-check-updates
            ];
          };
        };
      });
}
