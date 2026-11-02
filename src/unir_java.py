import os  # Importar el módulo os para interactuar con el sistema operativo y las rutas de carpetas

def consolidar_archivos_java(carpeta_entrada, archivo_salida):
    # Abrir el archivo de texto de salida en modo escritura ('w') con codificación UTF-8 para soportar tildes y caracteres especiales
    with open(archivo_salida, 'w', encoding='utf-8') as salida:
        
        # Recorrer de forma recursiva la carpeta de entrada utilizando os.walk para obtener carpetas y archivos
        for raiz, directorios, archivos in os.walk(carpeta_entrada):
            
            # Iterar sobre cada uno de los archivos encontrados en la ruta actual
            for archivo in archivos:
                
                # Comprobar si el archivo termina con la extensión .java (convirtiéndolo a minúsculas para evitar problemas)
                if archivo.lower().endswith('.java'):
                    
                    # Construir la ruta completa combinando el directorio raíz actual con el nombre del archivo
                    ruta_completa = os.path.join(raiz, archivo)
                    
                    # Escribir una cabecera separadora en el archivo de texto para identificar claramente a qué archivo pertenece el siguiente código
                    salida.write(f"\n\n========================================\n")
                    salida.write(f"--- ARCHIVO: {ruta_completa} ---\n")
                    salida.write(f"========================================\n\n")
                    
                    try:
                        # Abrir el archivo .java individual en modo lectura con codificación UTF-8
                        with open(ruta_completa, 'r', encoding='utf-8') as f_java:
                            
                            # Leer todo el contenido del archivo .java y escribirlo dentro del archivo de texto unificado
                            salida.write(f_java.read())
                            
                    except Exception as e:
                        # Capturar cualquier posible error de lectura (como permisos denegados) y escribir una advertencia en el txt
                        salida.write(f"\n[Error al intentar leer este archivo: {e}]\n")

# Definir la ruta de la carpeta donde están tus archivos .java (el punto '.' significa la carpeta actual donde ejecutas el script)
carpeta_objetivo = "./" 

# Definir el nombre del archivo de texto final que contendrá todo el código consolidado
archivo_resultado = "codigo_java_unificado.txt"

# Llamar a la función principal pasándole la carpeta de origen y el nombre del archivo de salida
consolidar_archivos_java(carpeta_objetivo, archivo_resultado)
