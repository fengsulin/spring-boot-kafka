package com.lne.kafka;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.lne.kafka.constant.MetricValue;
import com.lne.kafka.operator.entity.OperationInspection;
import com.lne.kafka.operator.service.IOperationInspectionService;
import com.lne.kafka.operator.service.impl.OperationInspectionServiceImpl;
import org.apache.kafka.common.PartitionInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class KafkaStudyApplicationTests {


	@Resource
	private KafkaTemplate<String,Object> kafkaTemplate;

	@Resource
	private IOperationInspectionService iOperationInspectionService;
//	@Test
//	void contextLoads() {
//		KafkaTarget kafkaTarget = new KafkaTarget("hhh", "a", LocalDateTime.now(), "c");
//		KafkaTarget kafkaTarget1 = new KafkaTarget("ggg", "as", LocalDateTime.now(), "sc");
//
//		ArrayList<KafkaTarget> objects = new ArrayList<>();
//		objects.add(kafkaTarget);
//		objects.add(kafkaTarget1);
//		kafkaTargetService.saveBatch(objects);
////		kafkaTargetMapper.saveBatch(objects);
////		kafkaTargetMapper.insert(kafkaTarget);
//	}

	@Test
	void getKafkaPartition(){
		List<PartitionInfo> partitionInfos = kafkaTemplate.partitionsFor("devops-prometheus");
		System.out.println(partitionInfos.size());
	}

	@Test
	void testInsertOrUpdate(){
		OperationInspection operationInspection = new OperationInspection();
		long inspectionId = IdWorker.getId();
		operationInspection.setId(inspectionId);
		operationInspection.setInspectionName("hhhhh");
		operationInspection.setInspectionValue("222");
		operationInspection.setInspectionTime(LocalDateTime.now());

		iOperationInspectionService.insertOrUpdate(operationInspection);
	}

}
