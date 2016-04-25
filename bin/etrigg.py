#!/usr/bin/env python3

# Requires python-requests library
import requests
import sys


COOKIE = "etriggrocks=y6zgvncnhn5wxlttgv6dfnidu2rewwq"

if sys.argv > 1:
  COOKIE = "etriggrocks="+sys.argv[1]
else:
  print("running with outdated cookie")
  print("Plase run with 'python etrigg.py <COOKIE>' for actual data")


headers = {
  "Host": "etrigg.com",
  "User-Agent": "Mozilla/5.0 (X11; Linux x86_64; rv:44.0) Gecko/20100101 Firefox/44.0",
  "Accept": "*/*",
  "Accept-Language": "en-US,en;q=0.5",
  "Accept-Encoding": "gzip, deflate, br",
  "DNT": "1",
  "X-Requested-With": "XMLHttpRequest",
  "Referer": "https://etrigg.com/",
  "Cookie": COOKIE,
  "Connection": "keep-alive"
}

r1 = requests.get("https://etrigg.com/event/list/?_=1457198671850", headers=headers)
r2 = requests.get("https://etrigg.com/event/list/?offset=60&_=1457198671850", headers=headers)
r3 = requests.get("https://etrigg.com/event/list/?offset=120&_=1457198671850", headers=headers)
r4 = requests.get("https://etrigg.com/event/list/?offset=180&_=1457198671850", headers=headers)
# print(r1.text)
# print(r2.text)
# print(r3.text)
# print(r4.text)

with open("etriggdata", "w+") as f:
  f.write(r1.text)
  f.write(r2.text)
  f.write(r3.text)
  f.write(r4.text)





