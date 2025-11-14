# Use a lightweight web server as the base image
# --platform to avoid Mac M1 build issues when deploying
# Ref.: https://stackoverflow.com/questions/65612411/forcing-docker-to-use-linux-amd64-platform-by-default-on-macos/69636473#69636473
# Not enough -> use buildx to build image
# Ref.: https://stackoverflow.com/questions/73285601/docker-exec-usr-bin-sh-exec-format-error
FROM --platform=linux/amd64 nginx:alpine

# Copy the files to the nginx default document root
COPY ./generated/ /usr/share/nginx/html

# Copy the nginx configuration file to the container
COPY nginx.conf /usr/share/nginx/html/nginx.conf

# Copy custom server config to use port 8080
COPY conf.d/default.conf /etc/nginx/conf.d/default.conf

# Fix permissions for nginx cache directory when running with non-root user
RUN mkdir -p /var/cache/nginx && chown -R nginx:nginx /var/cache/nginx /usr/share/nginx/html

# Expose port 8080 to allow incoming traffic
EXPOSE 8080

# Start the nginx web server with custom config (with updated pid path)
CMD ["nginx", "-c", "/usr/share/nginx/html/nginx.conf", "-g", "daemon off;"]

# Run as non-root user for better security
USER nginx