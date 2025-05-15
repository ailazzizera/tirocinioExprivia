db.createUser(
        {
            user: "assessmentdb",
            pwd: "esempio",
            roles: [
                {
                    role: "readWrite",
                    db: "assessmentdb"
                }
            ]
        }
);