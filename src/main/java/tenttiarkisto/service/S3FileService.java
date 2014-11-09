package tenttiarkisto.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import java.io.InputStream;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.stereotype.Service;

@Service
public class S3FileService implements FileService {

    private final AmazonS3 s3;
    private final Region ireland;
    private final String bucket;

    public S3FileService() {
        s3 = new AmazonS3Client();
        ireland = Region.getRegion(Regions.EU_WEST_1);
        s3.setRegion(ireland);

        bucket = "tentit";
    }

    @Override
    public String putFile(String name, InputStream is, long length) {
        try {
            ObjectMetadata data = new ObjectMetadata();
            data.setContentLength(length);
            
            PutObjectRequest req = new PutObjectRequest(bucket, name, is, data);
            s3.putObject(req);

            return "https://s3-eu-west-1.amazonaws.com/tentit/" + name;
        } catch (AmazonServiceException ase) {
            String msg = "Caught an AmazonServiceException, which means your request made it "
                    + "to Amazon S3, but was rejected with an error response for some reason.";
            msg += "\nError Message:    " + ase.getMessage();
            msg += "\nHTTP Status Code: " + ase.getStatusCode();
            msg += "\nAWS Error Code:   " + ase.getErrorCode();
            msg += "\nError Type:       " + ase.getErrorType();
            msg += "\nRequest ID:       " + ase.getRequestId();

            Logger.getLogger(S3FileService.class).error(msg);
            

            return null;
        } catch (AmazonClientException ace) {
            String msg = "Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with S3, "
                    + "such as not being able to access the network.";
            msg += "\nError Message: " + ace.getMessage();

            Logger.getLogger(S3FileService.class).error(msg);

            return null;
        }

    }

    @Override
    public String putFile(File f) {
        try {
            PutObjectRequest req = new PutObjectRequest(bucket, f.getName(), f);
            s3.putObject(req);

            return "https://s3-eu-west-1.amazonaws.com/tentit/" + f.getName();
        } catch (AmazonServiceException ase) {
            String msg = "Caught an AmazonServiceException, which means your request made it "
                    + "to Amazon S3, but was rejected with an error response for some reason.";
            msg += "\nError Message:    " + ase.getMessage();
            msg += "\nHTTP Status Code: " + ase.getStatusCode();
            msg += "\nAWS Error Code:   " + ase.getErrorCode();
            msg += "\nError Type:       " + ase.getErrorType();
            msg += "\nRequest ID:       " + ase.getRequestId();

            Logger.getLogger(S3FileService.class).log(Priority.ERROR, msg);

            return null;
        } catch (AmazonClientException ace) {
            String msg = "Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with S3, "
                    + "such as not being able to access the network.";
            msg += "\nError Message: " + ace.getMessage();

            Logger.getLogger(S3FileService.class).log(Priority.ERROR, msg);

            return null;
        }

    }

}
