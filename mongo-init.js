db = db.getSiblingDB("admin");
db.auth("admin", "secret");
db = db.getSiblingDB("crypto_dashboard");
db.createCollection("news");
