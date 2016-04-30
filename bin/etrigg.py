#!/usr/bin/env python3

# Requires python-requests library
import requests
import sys
from bs4 import BeautifulSoup


COOKIE = "etriggrocks=y6zgvncnhn5wxlttgv6dfnidu2rewwq"
COOKIE = "etriggrocks=i5vpvjp8iflsn1h5tt4fdn8s7nv4li1w"

if len(sys.argv) > 1:
  COOKIE = "etriggrocks="+sys.argv[1]
else:
  print("running with outdated cookie")
  print("Plase run with 'python etrigg.py <COOKIE>' for actual data")



events = []


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

def get_events():
  r1 = requests.get("https://etrigg.com/event/list/?_=1457198671850", headers=headers)
  r2 = requests.get("https://etrigg.com/event/list/?offset=60&_=1457198671850", headers=headers)
  r3 = requests.get("https://etrigg.com/event/list/?offset=120&_=1457198671850", headers=headers)
  r4 = requests.get("https://etrigg.com/event/list/?offset=180&_=1457198671850", headers=headers)

  with open("etriggdata", "w+") as f:
    f.write(r1.text)
    f.write(r2.text)
    f.write(r3.text)
    f.write(r4.text)


def parse_event(url):
  r1 = requests.get("https://etrigg.com"+url, headers=headers)
  soup = BeautifulSoup(r1.text, 'html.parser')
  event_name, location = soup.find_all("meta", itemprop='name')
  event = {}
  print("Name:", event_name["content"])
  print("start date:", soup.find(itemprop='startDate')["content"])
  print("end date:", soup.find(itemprop='endDate')["content"])
  print("end date:", soup.find(itemprop='endDate')["content"])
  print("Desc:", soup.find(itemprop='description').text)
  print("Location:", location["content"])
  print("Addr:", soup.find(itemprop='streetAddress').text)
  print("Url:", soup.find(class_="truncate").find("a", href=True)["href"])
  print("Category:", soup.find("i", title=True)["title"].split(": ")[1])

  event["Name"] = event_name["content"]
  event["start date"] = soup.find(itemprop='startDate')["content"]
  event["end date"] = soup.find(itemprop='endDate')["content"]
  event["end date"] = soup.find(itemprop='endDate')["content"]
  event["Desc"] = soup.find(itemprop='description').text
  event["Location"] = location["content"]
  event["Addr"] = soup.find(itemprop='streetAddress').text
  event["Url"] = soup.find(class_="truncate").find("a", href=True)["href"]
  event["Category"] = soup.find("i", title=True)["title"].split(": ")[1]
  print(event)
  events.append(event)





def parse_events():
  f = open("etriggdata", "r").read()
  soup = BeautifulSoup(f, 'html.parser')
  for i in soup.find_all(href=True):
    if "event" in i['href']:
      parse_event(i['href'])



parse_events()

import json
f = open("etrigg.json", "w")
f.write(json.dumps(events))
f.close()








