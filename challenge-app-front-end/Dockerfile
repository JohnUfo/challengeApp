# Use official Node.js image
FROM node:18

# Set working directory
WORKDIR /usr/src/app

# Copy dependency files
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the app
COPY . .

# Expose the port used by React dev server
EXPOSE 3000

# Start the development server
CMD ["npm", "start"]
