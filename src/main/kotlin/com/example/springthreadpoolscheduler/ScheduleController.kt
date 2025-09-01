package com.example.springthreadpoolscheduler

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

@RestController
class ScheduleController {

    private val scheduleThreadPool = ScheduledThreadPoolExecutor(2)
    private val formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")

    @GetMapping("/test-schedule")
    fun testSchedule(): String {
        println("스케줄링 시작: ${LocalDateTime.now().format(formatter)}")
        // 5초 뒤에 실행되는 작업
        scheduleThreadPool.schedule({
            println("지연 작업 1 실행: ${LocalDateTime.now().format(formatter)}")
        }, 5, TimeUnit.SECONDS)

        // 10초 뒤에 실행되는 작업
        scheduleThreadPool.schedule({
            println("지연 작업 2 실행: ${LocalDateTime.now().format(formatter)}")
        }, 10, TimeUnit.SECONDS)


        return "스케줄링 완료"

    }
}
