#!/usr/bin/env python
# -*- coding: utf-8 -*-
import unittest
import requests
import json
 
class PythonRequestsTest(unittest.TestCase):
    def setUp(self):
        #预置环境
        print '--------------Python Requests Test SetUp--------------\n'
    def tearDown(self): 
        #清理环境
        print '--------------Python Requests Test Clear--------------\n' 
         
    def test_get(self):
        print 'test_get:'
        url = "http://httpbin.org/get"  #测试的接口url
        headers = {'content-type': 'application/json'}
        r = requests.get(url=url, headers=headers)
        self.assertEqual(url, r.url, "url is wrong")
    
    def test_post(self):              
        print 'test_post:'
        pqyload = {'a':'homework1','b':'post test'}
        r = requests.post('http://httpbin.org/post',params = pqyload)
        data = r.json()
        self.assertEqual("homework1", data['args']['a'], "The value of 'a' is wrong")
        self.assertEqual("post test", data['args']['b'], "The value of 'b' is wrong")
        
        
def suite():
    suite = unittest.TestSuite()
    suite.addTest(PythonRequestsTest("test_get"))
    suite.addTest(PythonRequestsTest("test_post"))
    unittest.TextTestRunner().run(suite)
     
if __name__ == '__main__':
    suite()#执行suite