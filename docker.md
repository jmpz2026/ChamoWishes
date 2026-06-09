# Docker — Build & Push

Guía rápida para construir y subir la imagen de ChamoWishes.

## Variables

Reemplaza estos valores:

- `USUARIO` → tu usuario de Docker Hub (o registry).
- `chamowishes` → nombre de la imagen.
- `TAG` → versión (ej. `1.0.0`, o `latest`).

## Orden de comandos

### 1. Login (solo la primera vez o si expira)

```bash
docker login
```

### 2. Build — construir la imagen

Desde la raíz del proyecto (donde está el `Dockerfile`):

```bash
docker build -t USUARIO/chamowishes:TAG .
```

El `.` final es el contexto (carpeta actual). El `Dockerfile` es multi-stage:
compila con Maven y deja solo el JRE + el `.jar` en la imagen final.

### 3. (Opcional) Probar local antes de pushear

```bash
docker run -p 8080:8080 USUARIO/chamowishes:TAG
```

App queda en `http://localhost:8080`. `Ctrl+C` para parar.

### 4. Push — subir al registry

```bash
docker push USUARIO/chamowishes:TAG
```