import requests


url = "abc"
filename = "xyz"

try:
    # rq = requests.get(url, headers=headers, proxies=random_proxy())
    raise requests.exceptions.SSLError("Handshake!")
except Exception as e:
    print(f"{url} - {filename}" + str(e))
except requests.exceptions.SSLError as er:
    print(f"{url} - {filename}" + str(er))

