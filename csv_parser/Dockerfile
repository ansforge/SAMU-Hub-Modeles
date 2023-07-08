# Use a lightweight web server as the base image
# --platform to avoid Mac M1 build issues when deploying
# Ref.: https://stackoverflow.com/questions/65612411/forcing-docker-to-use-linux-amd64-platform-by-default-on-macos/69636473#69636473
# Not enough -> use buildx to build image
# Ref.: https://stackoverflow.com/questions/73285601/docker-exec-usr-bin-sh-exec-format-error
FROM --platform=linux/amd64 nginx:alpine

# Copy the static files to the nginx default document root
COPY asyncapi/ /usr/share/nginx/html

# Expose port 80 to allow incoming traffic
EXPOSE 80

# Start the nginx web server
CMD ["nginx", "-g", "daemon off;"]
