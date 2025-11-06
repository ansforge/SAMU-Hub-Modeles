# Use Python 3.11 slim as base image
FROM python:3.11-slim

# Set environment variables
ENV PYTHONDONTWRITEBYTECODE=1 \
    PYTHONUNBUFFERED=1 \
    UV_CACHE_DIR=/opt/uv-cache \
    UV_LINK_MODE=copy

# Install system dependencies and uv
RUN apt-get update && apt-get install -y \
    curl \
    ca-certificates \
    && rm -rf /var/lib/apt/lists/* \
    && curl -LsSf https://astral.sh/uv/install.sh | sh \
    && mv /root/.local/bin/uv /usr/local/bin/uv \
    && mv /root/.local/bin/uvx /usr/local/bin/uvx

# Create non-root user and group
RUN groupadd -r -g 1000 converter && \
    useradd -r -u 1000 -g converter -m -d /home/converter converter

# Create and set up working directory
WORKDIR /home/converter/app

# Create UV cache directory with proper permissions and set ownership of working directory
RUN mkdir -p $UV_CACHE_DIR && \
    chown -R converter:converter $UV_CACHE_DIR && \
    chown -R converter:converter /home/converter/app

# Switch to non-root user
USER converter

# Copy dependency files first for better layer caching
COPY --chown=converter:converter pyproject.toml uv.lock ./

# Install dependencies using uv
RUN uv sync --frozen --no-dev

# Copy application code
COPY --chown=converter:converter . .

# Expose port
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 \
    CMD curl -f http://localhost:8080/health || exit 1

# Use Gunicorn for production deployment
CMD ["uv", "run", "--no-dev", "gunicorn", "-w", "4", "-b", "0.0.0.0:8080", "converter.converter:app"]
