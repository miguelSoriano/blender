var gulp = require('gulp'),
    rollup = require('gulp-rollup'),
    babel = require('gulp-babel'),
    inject = require('gulp-inject'),
    series = require('stream-series'),
    sync = require('browser-sync'),
    rollPaths = require('rollup-plugin-includepaths')

gulp.task('js', function() {
    var appJS = gulp.src('./app/*.js')
        .pipe(rollup({
            plugins: [rollPaths()]
        }))
        .pipe(gulp.dest('./dist'))
    return gulp.src('index.html')
        .pipe(inject(series(appJS), {
            ignorePath:'dist',
            name: 'bundle',
            relative: true
        }))
        .pipe(gulp.dest('./dist'))
})
gulp.task('server', function() {
    sync({
        server: './dist'
    })
})
gulp.task('default', ['js', 'server'], function() {

})
