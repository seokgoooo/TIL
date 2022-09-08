package kr.co.greenart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarService service;

//	Jackson 라이브러리를 받으면 Spring의 WEB MVC랑 호환이 되서 JSON으로 자동으로 변환해준다.
	@GetMapping
	public @ResponseBody List<Car> view() {
		return service.list();
	}

//	Mapping할때 {}쓰면 변수처럼 사용할 수 있다.
	@GetMapping("/{id}")
	public @ResponseBody Car carById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping
	public ResponseEntity<String> add(@RequestBody Car car) {
		service.add(car);
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody Car car) {
		service.update(car);
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}
}