import requests
import collections


# basic request functionality and response storage tested.
r = collections.deque[requests.Response]
r = []
r.append(requests.post('https://httpbin.org/anything'))
r.append(requests.get('https://httpbin.org/get'))
r.append(requests.get('https://httpbin.org/post'))
r.append(requests.get('https://httpbin.org/cookies'))
r.append(requests.get('https://httpbin.org/gzip'))



for req in r:
    print(req.status_code)

