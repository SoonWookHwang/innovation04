package sparta.week4homework.dto;

import java.io.Serializable;

public interface ResponseDto<Post> extends Serializable {
        public enum Status { Successful, Failure }

        public Post getSource( );
        public Status getStatus( );
        public String getMessage( );
}
