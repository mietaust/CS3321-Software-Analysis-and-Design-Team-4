import requests


class ConnectionManager:
    __instance = None

    @classmethod
    def get_instance(cls, url):
        if ConnectionManager.__instance is None:
            ConnectionManager.__instance = ConnectionManager(url)
            return ConnectionManager.__instance

    def __init__(self, url):
        if ConnectionManager.__instance is not None:
            raise Exception("This is a singleton class ")
        else:
            print("Client attempting to connect")
            self.url = url
            ConnectionManager.__instance = self

    # asynchronous function to run HTTP GET request
    # input: URI of address to send GET request to (String)
    # return : asynchronous return from GET request to inputted URI
    def create_get_request(self, extension=""):
        try:
            user_request = requests.get(self.url + extension)
            return user_request
        except requests.exceptions.ConnectionError as e:
            print("CONNECTION ERROR", e)
        except requests.HTTPError as ex:
            print("HTTP ERROR", ex)
        except requests.ReadTimeout as er:
            print("TIMEOUT ERROR", er)
        except requests.Timeout as err:
            print("CONNECTION ERROR", err)
        except requests.exceptions.RequestException as error:
            print("CONNECTION ERROR", error)

    # Function for HTTP POST REQUEST
    # Input: url = location to send to, data = what to send
    def create_post_request(self, data, extension=""):
        try:
            user_post = requests.post((self.url + extension), data)
            return user_post
        except requests.exceptions.ConnectionError as e:
            print("CONNECTION ERROR", e)
        except requests.HTTPError as ex:
            print("HTTP ERROR", ex)
        except requests.ReadTimeout as er:
            print("TIMEOUT ERROR", er)
        except requests.Timeout as err:
            print("CONNECTION ERROR", err)
        except requests.exceptions.RequestException as error:
            print("CONNECTION ERROR", error)

    def test(self, url):
        self.url = url
        response_code = self.create_get_request()
        return response_code.status_code
