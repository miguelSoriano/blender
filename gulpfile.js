var gulp = require('gulp'),
    rollup = require('gulp-rollup'),
    babel = require('gulp-babel'),
    inject = require('gulp-inject'),
    concat = require('gulp-concat'),
    minify = require('gulp-uglify'),
    series = require('stream-series'),
    sync = require('browser-sync'),
    rollPaths = require('rollup-plugin-includepaths'),
    libs = require('./config.libs.js')

gulp.task('js', function() {
    var appLibs = gulp.src(libs.js)
        .pipe(concat('libs.js'))
        .pipe(gulp.dest('./dist'))

    var appJS = gulp.src('./app/*.js')
        .pipe(rollup({
            format:'cjs',
            plugins: [rollPaths()]
        }))
        .pipe(babel())
        .pipe(gulp.dest('./dist'))
    return gulp.src('index.html')
        .pipe(inject(series(appLibs,appJS), {
            ignorePath: 'dist',
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
