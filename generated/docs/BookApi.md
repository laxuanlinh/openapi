# BookApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getBookById**](BookApi.md#getBookById) | **GET** /book/{id} | Get book details by ID |
| [**getBooks**](BookApi.md#getBooks) | **GET** /book | Get a list of books |



## getBookById

> Book getBookById(id)

Get book details by ID

### Example

```java
// Import classes:
import com.example.openapi.client.ApiClient;
import com.example.openapi.client.ApiException;
import com.example.openapi.client.Configuration;
import com.example.openapi.client.models.*;
import com.example.openapi.client.api.BookApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        BookApi apiInstance = new BookApi(defaultClient);
        String id = "id_example"; // String | 
        try {
            Book result = apiInstance.getBookById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BookApi#getBookById");
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
| **id** | **String**|  | |

### Return type

[**Book**](Book.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Book found |  -  |


## getBooks

> List&lt;Book&gt; getBooks()

Get a list of books

### Example

```java
// Import classes:
import com.example.openapi.client.ApiClient;
import com.example.openapi.client.ApiException;
import com.example.openapi.client.Configuration;
import com.example.openapi.client.models.*;
import com.example.openapi.client.api.BookApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        BookApi apiInstance = new BookApi(defaultClient);
        try {
            List<Book> result = apiInstance.getBooks();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BookApi#getBooks");
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

[**List&lt;Book&gt;**](Book.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of books |  -  |

