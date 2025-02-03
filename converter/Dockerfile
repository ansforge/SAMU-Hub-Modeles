# Use an official Python runtime as a parent image
FROM python:3.11-slim

# Set environment variables for better security
ENV PYTHONDONTWRITEBYTECODE=1
ENV PYTHONUNBUFFERED=1

# Set the working directory in the container
WORKDIR /app

# Copy only necessary files to leverage Docker caching
COPY requirements.txt ./

# Install dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Copy the current directory contents into the container at /app
COPY . .

# Create a non-root user and group
RUN groupadd -r -g 1000 converter && useradd -r -u 1000 -g converter converter

# Change ownership of the working directory
RUN chown -R converter:converter /app

# Switch to the non-root user
USER converter

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Use Gunicorn to serve the Flask app
CMD ["gunicorn", "-w", "4", "-b", "0.0.0.0:8080", "converter.converter:app", "--timeout", "30", "--log-level", "debug"]
