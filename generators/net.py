import requests

MINECRAFT_VERSION = "1.18"
BASE_URL = "https://raw.githubusercontent.com/PrismarineJS/minecraft-data/master/data/pc/"


def get_json(res: str, minecraft_ver: str = MINECRAFT_VERSION):
    url = f"{BASE_URL}{minecraft_ver}/{res}"
    return requests.get(url).json()
