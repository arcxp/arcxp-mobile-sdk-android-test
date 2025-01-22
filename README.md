verify access to sdk:

open local.properties after building locally in android studio

add your github classic PAT (with read packages permission)

GITHUB_PERSONAL_ACCESS_TOKEN=pat

given this, gradle should sync and find the sdk dependency
