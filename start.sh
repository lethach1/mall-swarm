#!/bin/bash

echo "🚀 Starting mall-swarm project..."
echo "=================================="

# Kiểm tra Docker
echo "📦 Checking Docker..."
if ! docker --version > /dev/null 2>&1; then
    echo "❌ Docker is not running. Please start Docker Desktop first."
    exit 1
fi

# Di chuyển vào thư mục docker
echo "📁 Moving to docker directory..."
cd document/docker

# Khởi động infrastructure
echo "🏗️  Starting infrastructure services..."
echo "   - MySQL (port 3307)"
echo "   - Redis (port 6379)"
echo "   - Elasticsearch (port 9200)"
echo "   - Nacos (port 8848)"
echo "   - RabbitMQ (port 15672)"
echo "   - MongoDB (port 27017)"
echo "   - Kibana (port 5601)"
echo "   - Nginx (port 80)"

docker-compose -f docker-compose-env.yml up -d

# Đợi infrastructure khởi động
echo "⏳ Waiting for infrastructure to start (30 seconds)..."
sleep 30

# Kiểm tra infrastructure
echo "🔍 Checking infrastructure status..."
docker ps --format "table {{.Names}}\t{{.Status}}\t{{.Ports}}" | grep -E "(mysql|redis|elasticsearch|nacos|rabbitmq|mongo|kibana|nginx)"

# Khởi động applications
echo "🎯 Starting application services..."
echo "   - Gateway (port 8201)"
echo "   - Admin (port 8080)"
echo "   - Portal (port 8085)"
echo "   - Search (port 8081)"
echo "   - Auth (port 8401)"
echo "   - Monitor (port 8101)"

docker-compose -f docker-compose-app.yml up -d

# Đợi applications khởi động
echo "⏳ Waiting for applications to start (30 seconds)..."
sleep 30

# Kiểm tra applications
echo "🔍 Checking application status..."
docker ps --format "table {{.Names}}\t{{.Status}}\t{{.Ports}}" | grep -E "(mall-gateway|mall-admin|mall-portal|mall-search|mall-auth|mall-monitor)"

echo ""
echo "✅ Project started successfully!"
echo "=================================="
echo "🌐 Gateway: http://localhost:8201"
echo "📊 Monitor: http://localhost:8101"
echo "🔍 Nacos: http://localhost:8848/nacos"
echo "🐰 RabbitMQ: http://localhost:15672"
echo "📈 Kibana: http://localhost:5601"
echo "🔍 Elasticsearch: http://localhost:9200"
echo ""
echo "📋 Health Check:"
echo "   Gateway: http://localhost:8201/actuator/health"
echo "   Admin: http://localhost:8080/actuator/health"
echo "   Portal: http://localhost:8085/actuator/health"
echo ""
echo "🎉 Ready to use!"
