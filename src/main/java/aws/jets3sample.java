package aws;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.hazelcast.jet.pipeline.Pipeline;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

// import com.hazelcast.jet.s3.S3Sources;
import com.hazelcast.jet.Jet;
import com.hazelcast.jet.JetInstance;
import com.hazelcast.jet.pipeline.Pipeline;
import com.hazelcast.jet.pipeline.Sinks;
import com.hazelcast.jet.pipeline.Sources;


public class jets3sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("access_key_id", "secret_key_id");
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
		                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
		                        .build();
		/*
		BasicAWSCredentials credentials = BasicAWSCredentials.create("accessKeyId", "accessKeySecret");
		S3Client s3 = S3Client.builder()
		    .credentialsProvider(StaticCredentialsProvider.create(credentials))
		    .build();
		    */
   
		Pipeline p = Pipeline.create();
		/*
		p.readFrom(S3Sources.s3(singletonList("sshzdemo"), "prefix",  () -> S3Client.builder().credentialsProvider(StaticCredentialsProvider.create(credentials)).build())
		 .filter(line -> line.contains("ERROR"))
		 .writeTo(Sinks.logger()));
		 */
		
	}

}
