import unittest
from Frontend.main.GUI.ConnectionManager import ConnectionManager


class TestConnectionMethods(unittest.TestCase):
    # global Connection Manger
    connection = ConnectionManager.get_instance("https://httpbin.org/ip")

    # Test for the Connection Manager's GET method
    def test_get(self):
        l1 = self.connection.create_get_request()
        response_code = l1.status_code
        self.assertEqual(response_code, 200)  # add assertion here

    # Test for the Connection Manager's POST method
    def test_post(self):
        l1 = self.connection.create_post_request("hey")
        responsecode = l1.status_code
        self.assertEqual(responsecode, 405)  # add assertion here


if __name__ == '__main__':
    unittest.main()
