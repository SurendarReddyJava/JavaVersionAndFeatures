Java 8 introduced a comprehensive Base64 API in the `java.util` package, providing several features for encoding and decoding data. Here are the key features:

### 1. Basic Encoding and Decoding
- **Encoder**: Encodes byte data using the basic Base64 encoding scheme.
- **Decoder**: Decodes byte data using the basic Base64 encoding scheme.

```java
Base64.Encoder encoder = Base64.getEncoder();
String encodedString = encoder.encodeToString("Hello, World!".getBytes());
Base64.Decoder decoder = Base64.getDecoder();
String decodedString = new String(decoder.decode(encodedString));
```

### 2. URL and Filename Safe Encoding and Decoding
- Uses a URL and filename safe Base64 alphabet, substituting `+` and `/` with `-` and `_` respectively.
- Does not add any line separators.

```java
Base64.Encoder urlEncoder = Base64.getUrlEncoder();
String urlEncoded = urlEncoder.encodeToString("https://example.com".getBytes());
Base64.Decoder urlDecoder = Base64.getUrlDecoder();
String urlDecoded = new String(urlDecoder.decode(urlEncoded));
```

### 3. MIME Encoding and Decoding
- Encodes data using the MIME type Base64 encoding scheme.
- The encoded output is represented in lines of no more than 76 characters, using a carriage return (`\r`) followed by a linefeed (`\n`) as the line separator.

```java
Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
String mimeEncoded = mimeEncoder.encodeToString("This is a long string that needs to be encoded using MIME Base64 encoding.".getBytes());
Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
String mimeDecoded = new String(mimeDecoder.decode(mimeEncoded));
```

### 4. Encoding Without Padding
- Allows encoding without padding characters (`=`) at the end of the output.

```java
Base64.Encoder encoderWithoutPadding = Base64.getEncoder().withoutPadding();
String encodedWithoutPadding = encoderWithoutPadding.encodeToString("Hello, World!".getBytes());
```

### Summary of Methods
- **Basic Encoding/Decoding**:
  - `Base64.getEncoder()`
  - `Base64.getDecoder()`
- **URL and Filename Safe Encoding/Decoding**:
  - `Base64.getUrlEncoder()`
  - `Base64.getUrlDecoder()`
- **MIME Encoding/Decoding**:
  - `Base64.getMimeEncoder()`
  - `Base64.getMimeDecoder()`
- **Encoding Without Padding**:
  - `Base64.getEncoder().withoutPadding()`

These features make it easy to handle Base64 encoding and decoding in various contexts, such as URLs, filenames, and MIME types¹²³.
