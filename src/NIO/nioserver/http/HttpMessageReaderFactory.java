package NIO.nioserver.http;

import NIO.nioserver.IMessageReader;
import NIO.nioserver.IMessageReaderFactory;
import NIO.nioserver.MessageBuffer;

/**
 * Created by jjenkov on 18-10-2015.
 */
public class HttpMessageReaderFactory implements IMessageReaderFactory {

    public HttpMessageReaderFactory() {
    }

    @Override
    public IMessageReader createMessageReader() {
        return new HttpMessageReader();
    }
}
