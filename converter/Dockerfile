# Build stage: the -dev image includes tools needed to install packages.
FROM dhi.io/python:3.14-alpine3.23-dev AS builder

# Set environment variables
ENV PYTHONDONTWRITEBYTECODE=1
ENV PYTHONUNBUFFERED=1

# Install system dependencies and uv
RUN pip install --quiet --root-user-action=ignore uv
# Use copy mode since the cache and build filesystem are on different volumes.
ENV UV_LINK_MODE=copy

WORKDIR /app

# Install dependencies into a virtual environment using cache and bind mounts
# so neither uv nor the lock files need to be copied into the image.
RUN --mount=type=cache,target=/root/.cache/uv \
    --mount=type=bind,source=uv.lock,target=uv.lock \
    --mount=type=bind,source=pyproject.toml,target=pyproject.toml \
    uv sync --frozen --no-dev --no-install-project

# Create metrics directory during first stage because mkdir
# is not available in non dev base image
RUN mkdir -p /prometheus_metrics

# Runtime stage: minimal DHI image with no shell or package manager,
# already runs as the nonroot user.
FROM dhi.io/python:3.14-alpine3.23

ARG CONVERTER_VERSION

# Prevent Python from buffering stdout/stderr so logs appear immediately.
ENV PYTHONUNBUFFERED=1
# Activate the virtual environment copied from the build stage.
ENV PATH="/app/.venv/bin:$PATH"

WORKDIR /app

# Copy the pre-built virtual environment and application source code.
COPY --from=builder /app/.venv /app/.venv
COPY . .

# Make port 8080 available to the world outside this container
EXPOSE 8080

ENV FLASK_ENV=production
ENV CONVERTER_VERSION=${CONVERTER_VERSION}

# Flask Prometheus Exporter setup
COPY --from=builder --chown=nonroot:nonroot /prometheus_metrics /tmp/prometheus_metrics
ENV PROMETHEUS_MULTIPROC_DIR=/tmp/prometheus_metrics

# Use Gunicorn for production deployment
CMD ["gunicorn", "-c", "gunicorn.conf.py", "-w", "2", "-b", "0.0.0.0:8080", "converter.converter:app"]
