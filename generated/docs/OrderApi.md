# OrderApi

All URIs are relative to *https://orderservice.example.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createOrder**](OrderApi.md#createOrder) | **POST** /order | Create a new order |
| [**getOrder**](OrderApi.md#getOrder) | **GET** /order | Get the current order |
| [**updateOrder**](OrderApi.md#updateOrder) | **PUT** /order | Update the current order |



## createOrder

> createOrder(order)

Create a new order

### Example

```java
// Import classes:
import com.example.openapi.client.ApiClient;
import com.example.openapi.client.ApiException;
import com.example.openapi.client.Configuration;
import com.example.openapi.client.models.*;
import com.example.openapi.client.api.OrderApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://orderservice.example.com/api");

        OrderApi apiInstance = new OrderApi(defaultClient);
        Order order = new Order(); // Order | 
        try {
            apiInstance.createOrder(order);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrderApi#createOrder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **order** | [**Order**](Order.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Order created successfully |  -  |
| **400** | Invalid order data |  -  |
| **500** | Internal server error |  -  |


## getOrder

> Order getOrder()

Get the current order

### Example

```java
// Import classes:
import com.example.openapi.client.ApiClient;
import com.example.openapi.client.ApiException;
import com.example.openapi.client.Configuration;
import com.example.openapi.client.models.*;
import com.example.openapi.client.api.OrderApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://orderservice.example.com/api");

        OrderApi apiInstance = new OrderApi(defaultClient);
        try {
            Order result = apiInstance.getOrder();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrderApi#getOrder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**Order**](Order.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The current order |  -  |
| **404** | Order not found |  -  |
| **500** | Internal server error |  -  |


## updateOrder

> updateOrder(order)

Update the current order

### Example

```java
// Import classes:
import com.example.openapi.client.ApiClient;
import com.example.openapi.client.ApiException;
import com.example.openapi.client.Configuration;
import com.example.openapi.client.models.*;
import com.example.openapi.client.api.OrderApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://orderservice.example.com/api");

        OrderApi apiInstance = new OrderApi(defaultClient);
        Order order = new Order(); // Order | 
        try {
            apiInstance.updateOrder(order);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrderApi#updateOrder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **order** | [**Order**](Order.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Order updated successfully |  -  |
| **400** | Invalid order data |  -  |
| **404** | Order not found |  -  |
| **500** | Internal server error |  -  |

