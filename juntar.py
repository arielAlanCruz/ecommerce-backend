import os

carpeta = os.getcwd()
salida = "codigo_completo.txt"

# Carpetas de build, IDE y control de versiones a omitir
IGNORAR = {"target", "build", ".git", ".idea", ".gradle", "bin", ".mvn"}

encontrados = 0

with open(salida, "w", encoding="utf-8") as out:
    for root, dirs, files in os.walk(carpeta):
        # Filtra 'dirs' in-place para que os.walk ni siquiera entre a esas carpetas
        dirs[:] = [d for d in dirs if d not in IGNORAR]

        for archivo in files:
            if archivo.endswith(".java"):
                ruta_completa = os.path.join(root, archivo)
                ruta_relativa = os.path.relpath(ruta_completa, carpeta)

                out.write("\n" + "=" * 80 + "\n")
                out.write(f"ARCHIVO: {ruta_relativa}\n")
                out.write("=" * 80 + "\n\n")

                try:
                    with open(ruta_completa, "r", encoding="utf-8", errors="replace") as f:
                        out.write(f.read())
                        out.write("\n")
                    encontrados += 1
                except Exception as e:
                    out.write(f"// Error al leer archivo: {e}\n")

print(f"Listo! Archivo generado: {salida}")
print(f"Archivos .java procesados: {encontrados}")