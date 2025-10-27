#!/bin/bash

echo "🛑 Stopping mall-swarm project..."
echo "================================="

# Di chuyển vào thư mục docker
echo "📁 Moving to docker directory..."
cd document/docker

# Dừng applications
echo "🎯 Stopping application services..."
echo "   - Gateway"
echo "   - Admin"
echo "   - Portal"
echo "   - Search"
echo "   - Auth"
echo "   - Monitor"

docker-compose -f docker-compose-app.yml down

# Dừng infrastructure
echo "🏗️  Stopping infrastructure services..."
echo "   - MySQL"
echo "   - Redis"
echo "   - Elasticsearch"
echo "   - Nacos"
echo "   - RabbitMQ"
echo "   - MongoDB"
echo "   - Kibana"
echo "   - Nginx"

docker-compose -f docker-compose-env.yml down

# Kiểm tra trạng thái
echo "🔍 Checking status..."
echo "Remaining containers:"
docker ps --format "table {{.Names}}\t{{.Status}}\t{{.Ports}}"

echo ""
echo "✅ Project stopped successfully!"
echo "================================="
echo "💾 Data is preserved (not deleted)"
echo "🔄 To start again, run: ./start.sh"
echo ""
echo "⚠️  To completely reset (delete all data):"
echo "   docker-compose -f docker-compose-env.yml down -v"
echo "   docker-compose -f docker-compose-app.yml down -v"
